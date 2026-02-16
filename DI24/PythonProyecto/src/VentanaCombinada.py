import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QVBoxLayout, QLineEdit, QPushButton, QLabel, QWidget

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Aplicación Completa")
        self.setGeometry(100, 100, 400, 300)

        # Widget central y layout
        widget_central = QWidget(self)
        layout = QVBoxLayout(widget_central)

        # Crear widgets
        self.etiqueta = QLabel("Escribe algo abajo:", self)
        self.campo_texto = QLineEdit(self)
        boton = QPushButton("Actualizar", self)
        boton.clicked.connect(self.actualizar_texto)

        # Añadir widgets al layout
        layout.addWidget(self.etiqueta)
        layout.addWidget(self.campo_texto)
        layout.addWidget(boton)

        # Configurar el widget central
        self.setCentralWidget(widget_central)

    def actualizar_texto(self):
        texto = self.campo_texto.text()
        self.etiqueta.setText(f"Texto actualizado: {texto}")

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())
