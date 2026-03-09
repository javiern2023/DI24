import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QVBoxLayout, QPushButton, QWidget

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Layouts en PyQt6")
        self.setGeometry(100, 100, 400, 300)

        # Crear un widget central y un layout
        widget_central = QWidget(self)
        layout = QVBoxLayout(widget_central)

        # Crear botones y añadirlos al layout
        boton1 = QPushButton("Botón 1", self)
        boton2 = QPushButton("Botón 2", self)
        boton3 = QPushButton("Botón 3", self)

        layout.addWidget(boton1)
        layout.addWidget(boton2)
        layout.addWidget(boton3)

        # Configurar el widget central
        self.setCentralWidget(widget_central)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())
