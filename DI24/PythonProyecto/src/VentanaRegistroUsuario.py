import sys
from PyQt6.QtWidgets import (
    QApplication, QMainWindow, QVBoxLayout, QHBoxLayout, QWidget,
    QLineEdit, QPushButton, QTableWidget, QTableWidgetItem, QLabel, QMessageBox, QHeaderView
)


class VentanaRegistro(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Registro de Usuarios")
        self.setGeometry(100, 100, 700, 400)

        # Widget central y layout principal
        widget_central = QWidget()
        layout_principal = QVBoxLayout(widget_central)

        # Layout para los campos de entrada
        layout_campos = QHBoxLayout()

        # Etiqueta y campo para el DNI
        self.label_dni = QLabel("DNI:")
        self.campo_dni = QLineEdit()
        layout_campos.addWidget(self.label_dni)
        layout_campos.addWidget(self.campo_dni)

        # Etiqueta y campo para el nombre
        self.label_nombre = QLabel("Nombre:")
        self.campo_nombre = QLineEdit()
        layout_campos.addWidget(self.label_nombre)
        layout_campos.addWidget(self.campo_nombre)

        # Etiqueta y campo para la edad
        self.label_edad = QLabel("Edad:")
        self.campo_edad = QLineEdit()
        layout_campos.addWidget(self.label_edad)
        layout_campos.addWidget(self.campo_edad)

        # Etiqueta y campo para el correo
        self.label_correo = QLabel("Correo:")
        self.campo_correo = QLineEdit()
        layout_campos.addWidget(self.label_correo)
        layout_campos.addWidget(self.campo_correo)

        layout_principal.addLayout(layout_campos)

        # Tabla para mostrar los usuarios
        self.tabla = QTableWidget()
        self.tabla.setColumnCount(4)  # Número de columnas (incluyendo DNI)
        self.tabla.setHorizontalHeaderLabels(["DNI", "Nombre", "Edad", "Correo"])
        self.tabla.setSelectionBehavior(QTableWidget.SelectionBehavior.SelectRows)
        self.tabla.setSelectionMode(QTableWidget.SelectionMode.SingleSelection)

        # Ajustar el ancho de las columnas para que se adapten al ancho de la ventana
        self.tabla.horizontalHeader().setSectionResizeMode(QHeaderView.ResizeMode.Stretch)

        layout_principal.addWidget(self.tabla)

        # Layout para los botones
        layout_botones = QHBoxLayout()

        # Botón para insertar
        self.boton_insertar = QPushButton("Insertar")
        self.boton_insertar.clicked.connect(self.insertar_usuario)
        layout_botones.addWidget(self.boton_insertar)

        # Botón para eliminar
        self.boton_eliminar = QPushButton("Eliminar")
        self.boton_eliminar.clicked.connect(self.eliminar_usuario)
        layout_botones.addWidget(self.boton_eliminar)

        # Botón para limpiar campos
        self.boton_limpiar = QPushButton("Limpiar")
        self.boton_limpiar.clicked.connect(self.limpiar_campos)
        layout_botones.addWidget(self.boton_limpiar)

        # Botón para cerrar
        self.boton_cerrar = QPushButton("Cerrar")
        self.boton_cerrar.clicked.connect(self.close)
        layout_botones.addWidget(self.boton_cerrar)

        layout_principal.addLayout(layout_botones)

        # Configurar el widget central
        self.setCentralWidget(widget_central)

    def insertar_usuario(self):
        """Inserta un nuevo usuario en la tabla si el DNI no existe."""
        dni = self.campo_dni.text().strip()
        nombre = self.campo_nombre.text().strip()
        edad = self.campo_edad.text().strip()
        correo = self.campo_correo.text().strip()

        # Validar campos
        if not dni or not nombre or not edad or not correo:
            QMessageBox.warning(self, "Error", "Todos los campos son obligatorios.")
            return

        if not edad.isdigit():
            QMessageBox.warning(self, "Error", "La edad debe ser un número.")
            return

        # Comprobar si el DNI ya existe
        if self.dni_existe(dni):
            QMessageBox.warning(self, "Error", f"El DNI '{dni}' ya está registrado.")
            return

        # Insertar el usuario en la tabla
        fila_actual = self.tabla.rowCount()
        self.tabla.insertRow(fila_actual)
        self.tabla.setItem(fila_actual, 0, QTableWidgetItem(dni))
        self.tabla.setItem(fila_actual, 1, QTableWidgetItem(nombre))
        self.tabla.setItem(fila_actual, 2, QTableWidgetItem(edad))
        self.tabla.setItem(fila_actual, 3, QTableWidgetItem(correo))

        self.limpiar_campos()  # Limpiar los campos después de insertar

    def dni_existe(self, dni):
        """Comprueba si un DNI ya está registrado en la tabla."""
        for fila in range(self.tabla.rowCount()):
            dni_existente = self.tabla.item(fila, 0).text()
            if dni_existente == dni:
                return True
        return False

    def eliminar_usuario(self):
        """Elimina la fila seleccionada de la tabla."""
        fila_seleccionada = self.tabla.currentRow()
        if fila_seleccionada == -1:
            QMessageBox.warning(self, "Error", "Por favor, selecciona una fila para eliminar.")
            return

        self.tabla.removeRow(fila_seleccionada)

    def limpiar_campos(self):
        """Limpia los campos de entrada."""
        self.campo_dni.clear()
        self.campo_nombre.clear()
        self.campo_edad.clear()
        self.campo_correo.clear()


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaRegistro()
    ventana.show()
    sys.exit(app.exec())

