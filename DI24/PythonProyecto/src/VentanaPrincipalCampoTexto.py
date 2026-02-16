import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QLineEdit, QPushButton, QLabel

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Entrada de Texto")
        self.setGeometry(100, 100, 400, 300)

        # Etiqueta
        self.etiqueta = QLabel("Escribe algo:", self)
        self.etiqueta.move(20, 50)

        # Campo de entrada de texto
        self.campo_texto = QLineEdit(self)
        self.campo_texto.setGeometry(20, 80, 250, 30)

        # Botón
        boton = QPushButton("Mostrar Texto", self)
        boton.setGeometry(20, 130, 120, 30)
        boton.clicked.connect(self.mostrar_texto)

    def mostrar_texto(self):
        texto = self.campo_texto.text()  # Obtener el texto del campo
        self.etiqueta.setText(f"Escribiste: {texto}")  # Mostrar el texto en la etiqueta

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())

