import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QMessageBox

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana con Botón")
        self.setGeometry(100, 100, 400, 300)

        # Crear un botón
        boton = QPushButton("Haz clic aquí", self)
        boton.setGeometry(150, 130, 100, 40)  # Posición y tamaño del botón
        boton.clicked.connect(self.mostrar_mensaje)  # Conectar el clic del botón a un método

    # Método para mostrar un mensaje
    def mostrar_mensaje(self):
        QMessageBox.information(self, "Mensaje", "¡Has hecho clic en el botón!")

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())

