# main.py
import sys
from PyQt6.QtWidgets import QApplication
from login import VentanaLogin

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaLogin()
    ventana.show()
    sys.exit(app.exec())