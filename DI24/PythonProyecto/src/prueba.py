'''
Created on 17 ene 2025

@author: javi
'''
from PyQt6.QtWidgets import QApplication, QLabel

# Crea la aplicación
app = QApplication([])

# Crea un widget (una etiqueta en este caso)
label = QLabel("¡Hola, PyQt6 desde Eclipse!")
label.show()

# Ejecuta el bucle de eventos
app.exec()
