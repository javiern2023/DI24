import sys
from PyQt6 import uic
from PyQt6.QtWidgets import QApplication, QMainWindow

class PruebaWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        # Cargar la ventana diseñada en Qt Designer
        uic.loadUi("ui/Prueba.ui", self)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = PruebaWindow()
    window.show()
    sys.exit(app.exec())
