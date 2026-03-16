from PyQt6 import uic #carga interfaces gráficas creadas con QtDesigner
from PyQt6.QtWidgets import QMainWindow, QApplication, QMessageBox #Clase base para la ventana principal, gestionar la interfaz gráfica, ventanas de aviso
from PyQt6.QtGui import QPixmap #para mostrar imágenes
from PyQt6.QtCore import QThread, pyqtSignal #ejecutar tareas en segundo plano, enviar resultaos del hilo a la interfz
from tabla import VentanaTabla #ventana que abre después del login
from baseDatos import BaseDatos #clase que gestiona las consulas a MySQL
import os #se usa para manejar rutas de archivos

# Hilo para login
class LoginThread(QThread): #usa un hilo secundario para que la interfaz no se bloquee en las consultas a la base de datos
    finished = pyqtSignal(object) #define señal personalizada que enviará el resultado del login a la ventana principal

    def __init__(self, usuario, contrasenia, bd): #inicialización de la ventana
        super().__init__()
        self.usuario = usuario
        self.contrasenia = contrasenia
        self.bd = bd

    def run(self): #método que se ejecuta cuando el hilo empieza
        try:
            resultado = self.bd.comprobar_login(self.usuario, self.contrasenia) #consulta a la base de datos.
            self.finished.emit(resultado) #se envía a la ventana principal el resultado.
        except Exception as e:
            self.finished.emit(e) #si ocurre un error en el envio a la ventana principal se lanza una excepción.

# Ventana principal
class VentanaLogin(QMainWindow):
    def __init__(self):
        super().__init__() #se inicializa la ventana
        uic.loadUi("ui/VentanaLogeoUniversidad.ui", self) #se carga la ventana diseñada en QtDesigner

        # Logo
        ruta_logo = os.path.join(os.path.dirname(__file__), "imagenes", "logo.png") #se carga el logo
        if os.path.exists(ruta_logo): #comprueba que la ruta existe. Si existe se muestra el label
            self.label_4.setPixmap(QPixmap(ruta_logo))

        # Base de datos
        self.bd = BaseDatos() #creamos la instancia a la base de datos

        # ComboBox: primero opción "Seleccione una opción"
        self.comboBox.clear() #Primero limpiamos
        self.comboBox.addItem("Seleccione una opción")

        # Cargar cargos desde BD
        self.cargar_cargos()

        # Botones
        self.btnSalir.clicked.connect(QApplication.quit)
        self.btnEntrar.clicked.connect(self.iniciar_login)

    def cargar_cargos(self):
        """Carga los cargos desde la tabla cargo en la base de datos."""
        try:
            cargos = self.bd.obtener_cargos()  # devuelve lista de diccionarios [{'nombre': 'Profesor'}, ...]
            for cargo in cargos: #bucle para ir cargando los valores en el comboBox
                self.comboBox.addItem(cargo['nombre'])
        except Exception as e:
            print("Error cargando cargos:", e)
            QMessageBox.warning(self, "Error BD", "No se pudieron cargar los cargos")

    def iniciar_login(self):
        usuario = self.lineEdit.text().strip()
        contrasenia = self.lineEdit_2.text().strip()

        if not usuario or not contrasenia:
            QMessageBox.warning(self, "Error", "Introduce usuario y contraseña")
            return

        # Ejecutar login en un hilo
        self.thread = LoginThread(usuario, contrasenia, self.bd) #Se crea el hilo para consultar a la base de datos
        self.thread.finished.connect(self.login_terminado) #Cuando termina el hilo se ejecuta ese método
        self.thread.start() #Inicio del hilo.

    def login_terminado(self, resultado):
        if isinstance(resultado, Exception): #Excepción o error en el hilo
            QMessageBox.critical(self, "Error BD", f"Error al consultar la base de datos:\n{resultado}")
        elif resultado:
            QMessageBox.information(self, "Login correcto", f"Bienvenido {resultado['nombre']}")
            self.lineEdit.clear()
            self.lineEdit_2.clear()
            self.ventana_tabla = VentanaTabla()
            self.ventana_tabla.show()
        else:
            QMessageBox.warning(self, "Error", "Usuario o contraseña incorrectos")