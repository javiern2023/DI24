# login.py
import os
from PyQt6 import uic
from PyQt6.QtWidgets import QMainWindow, QApplication, QMessageBox
from PyQt6.QtGui import QPixmap
from tabla import VentanaTabla  # Importa la clase de la ventana de tabla

class VentanaLogin(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("ui/VentanaLogeoUniversidad.ui", self)

        # Cargar logo
        ruta_logo = os.path.join(os.path.dirname(__file__), "imagenes", "logo.png")
        self.label_4.setPixmap(QPixmap(ruta_logo))

        # Conectar botones
        self.btnSalir.clicked.connect(QApplication.quit)
        self.btnEntrar.clicked.connect(self.entrar)

    def entrar(self):
        usuario = self.lineEdit.text()
        contrasenia = self.lineEdit_2.text()

        if usuario == "Javier" and contrasenia == "1234":
            QMessageBox.information(self, "Login correcto", "Usuario y contraseña correctos")
            self.lineEdit.clear()
            self.lineEdit_2.clear()
            self.ventana_tabla = VentanaTabla()
            self.ventana_tabla.show()
        else:
            QMessageBox.warning(self, "Error", "Usuario o contraseña incorrectos")