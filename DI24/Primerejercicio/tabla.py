# tabla.py
from PyQt6 import uic
from PyQt6.QtWidgets import QMainWindow, QTableWidgetItem, QMessageBox
from baseDatos import BaseDatos


class VentanaTabla(QMainWindow):

    def __init__(self):
        super().__init__()
        uic.loadUi("ui/VentanaTabla.ui", self)

        # Campo contraseña con asteriscos
        self.lePass.setEchoMode(self.lePass.EchoMode.Password)

        # Instancia de base de datos
        self.bd = BaseDatos()

        # Botones
        self.btnSalir.clicked.connect(self.close)
        self.pushButton.clicked.connect(self.insertar_datos)

        # Checkboxes exclusivos
        self.checkBox.toggled.connect(lambda checked: self.unico_check(self.checkBox, checked))
        self.checkBox_2.toggled.connect(lambda checked: self.unico_check(self.checkBox_2, checked))
        self.checkBox_3.toggled.connect(lambda checked: self.unico_check(self.checkBox_3, checked))

        # Cargar datos en la tabla
        self.cargar_tabla()


    # Solo permite un checkbox marcado
    def unico_check(self, checkbox, checked):
        if checked:
            for cb in [self.checkBox, self.checkBox_2, self.checkBox_3]:
                if cb != checkbox:
                    cb.setChecked(False)


    # Cargar tabla desde la base de datos
    def cargar_tabla(self):

        try:
            usuarios = self.bd.obtener_usuarios()

            self.tableWidget.setRowCount(0)

            for datos in usuarios:

                fila = self.tableWidget.rowCount()
                self.tableWidget.insertRow(fila)

                self.tableWidget.setItem(fila, 0, QTableWidgetItem(str(datos["id"])))
                self.tableWidget.setItem(fila, 1, QTableWidgetItem(datos["nombre"]))
                self.tableWidget.setItem(fila, 2, QTableWidgetItem(datos["contrasenia"]))
                self.tableWidget.setItem(fila, 3, QTableWidgetItem(datos["ciclo"]))

        except Exception as e:
            print("Error cargando tabla:", e)
            QMessageBox.critical(self, "Error", f"No se pudo cargar la tabla\n{e}")


    # Insertar usuario en la base de datos
    def insertar_datos(self):

        usuario = self.leUsuario.text().strip()
        password = self.lePass.text().strip()

        ciclo = ""

        if self.checkBox.isChecked():
            ciclo = "DAM"
        elif self.checkBox_2.isChecked():
            ciclo = "DAW"
        elif self.checkBox_3.isChecked():
            ciclo = "ASIR"

        # Validación
        if not usuario or not password or not ciclo:
            QMessageBox.warning(self, "Error", "Todos los campos deben estar rellenos")
            return

        correcto = self.bd.insertar_usuario(usuario, password, ciclo)

        if correcto:

            QMessageBox.information(self, "Correcto", "Usuario insertado correctamente")

            # Limpiar campos
            self.leUsuario.clear()
            self.lePass.clear()
            self.leID.clear()

            self.checkBox.setChecked(True)
            self.checkBox_2.setChecked(False)
            self.checkBox_3.setChecked(False)

            # Recargar tabla
            self.cargar_tabla()

        else:
            QMessageBox.critical(self, "Error", "No se pudo insertar el usuario")