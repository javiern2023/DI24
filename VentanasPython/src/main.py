# main.py
import sys
import mysql.connector
from PyQt6.QtWidgets import QApplication, QMainWindow, QMessageBox
from ventanaLogeo import Ui_ventanaRegistro  # Importa la UI del login
from VentanaPrincipal import Ui_MainWindow  # Importa la clase VentanaPrincipal

class VentanaLogin(QMainWindow, Ui_ventanaRegistro):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

        # Conectar botón de login
        self.botonEntrar.clicked.connect(self.verificar_credenciales)

    def verificar_credenciales(self):
        usuario_ingresado = self.campoUsuario.toPlainText()  # Si es QLineEdit
        contrasena_ingresada = self.lineEdit.text()  # Si es QLineEdit

        estado = self.validar_usuario_bd(usuario_ingresado, contrasena_ingresada)

        if estado == "ok":
            self.abrir_ventana_principal()
        elif estado == "no_registrado":
            self.mostrar_mensaje("Usuario no registrado")
        else:
            self.mostrar_mensaje("Contraseña incorrecta")

    def validar_usuario_bd(self, nombre, contrasena):
        try:
            conexion = mysql.connector.connect(
                host="localhost",
                user="root",  # Usuario por defecto en XAMPP
                password="",  # Sin contraseña por defecto en XAMPP
                database="universidad"
            )
            '''
            cursor es un objeto que permite ejecutar consultas SQL y recorrer 
            los resultados dentro de una base de datos MySQL.
            ✅ cursor.execute() → Ejecuta consultas SQL
            ✅ fetchone() → Trae un solo resultado
            ✅ fetchall() → Trae todos los resultados
            ✅ commit() → Guarda cambios después de INSERT, UPDATE, DELETE
            ✅ cursor.close() → Cierra el cursor cuando ya no se necesita
            '''
            cursor = conexion.cursor()

            # Primero, verificar si el usuario existe
            query_usuario = "SELECT pass FROM registro WHERE nombre = %s"
            cursor.execute(query_usuario, (nombre,))
            #Obtiene la primera fila que coincide
            resultado = cursor.fetchone()

            if resultado is None:
                return "no_registrado"  # Usuario no encontrado

            # Si el usuario existe, verificar contraseña
            if resultado[0] == contrasena:
                return "ok"  # Usuario y contraseña correctos
            else:
                return "contraseña_incorrecta"  # Contraseña incorrecta

        except mysql.connector.Error as e:
            print(f"Error al conectar con MySQL: {e}")
            return "error"

        finally:
            cursor.close()
            conexion.close()

    def abrir_ventana_principal(self):
        # Crear una instancia de QMainWindow
        self.ventana_principal = QMainWindow()

        # Crear una instancia de Ui_MainWindow y aplicar la UI a la ventana
        self.ui = Ui_MainWindow()  # Crear la instancia aquí
        self.ui.setupUi(self.ventana_principal)  # Usar setupUi para aplicar la UI a la ventana

        # Mostrar la ventana principal
        self.ventana_principal.show()
        self.close()  # Cerrar la ventana de login

    def mostrar_error(self):
        msg = QMessageBox(self)
        msg.setWindowTitle("Error")
        msg.setText("Usuario o contraseña incorrectos")
        msg.setIcon(QMessageBox.Icon.Critical)
        msg.exec()
       
    def mostrar_mensaje(self, mensaje):
        msg = QMessageBox(self)
        msg.setWindowTitle("Mensaje")
        msg.setText(mensaje)
        msg.setIcon(QMessageBox.Icon.Warning)
        msg.exec()    

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaLogin()
    ventana.show()
    sys.exit(app.exec())
