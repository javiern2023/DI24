'''
Cada aplicación PyQt6 necesita un objeto QApplication para manejar eventos y una ventana 
principal.

Algunos widgets importantes en PyQt6:

QLabel: Mostrar texto o imágenes.
QLineEdit: Campo de texto para entrada de datos.
QPushButton: Botones para acciones.
QCheckBox: Casillas de verificación.
QComboBox: Menú desplegable.

Los layouts ayudan a organizar widgets en la ventana. Algunos tipos de layouts:

QVBoxLayout: Disposición vertical.
QHBoxLayout: Disposición horizontal.
QGridLayout: Disposición en cuadrícula.

En Python, self es una referencia al objeto actual (la instancia de una clase) y se usa d
entro de las clases para acceder a los atributos y métodos de esa instancia. 
Es un mecanismo clave en la programación orientada a objetos en Python.

Aunque el nombre self es una convención, puedes llamarlo de cualquier otra forma (aunque no 
es recomendable por legibilidad y consistencia). Sin embargo, el primer parámetro de 
cualquier método dentro de una clase debe referirse al objeto de la instancia actual.

'''

import sys
from PyQt6.QtWidgets import QApplication, QMainWindow

# Clase principal de la ventana
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__() # Inicio de la ventana
        self.setWindowTitle("Ventana Básica con PyQt6") # Título de la ventana
        self.setGeometry(100, 100, 400, 300)  # Posición y tamaño (x, y, ancho, alto)

# Código principal
if __name__ == "__main__":
    app = QApplication(sys.argv)  # Crear la aplicación
    ventana = VentanaPrincipal()  # Crear una instancia de la ventana
    ventana.show()  # Mostrar la ventana
    sys.exit(app.exec())  # Ejecutar el bucle de eventos

