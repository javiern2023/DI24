'''
Entrada de datos:
QLineEdit para los campos de texto (nombre, apellido y teléfono).
QDateEdit con un calendario emergente para seleccionar la fecha. Se asegura de que la fecha 
mínima sea la actual.

Validaciones:
Si la fecha seleccionada es anterior a hoy, el programa no lo permitirá gracias a 
setMinimumDate().
Si los campos están vacíos, se muestra un mensaje de advertencia con QMessageBox.

Tabla:
QTableWidget para mostrar las citas en una tabla. Las citas no son editables directamente.

Botones:
Agregar: Valida y añade la cita a la tabla.
Limpiar: Limpia todos los campos de entrada.
Eliminar: Elimina la fila seleccionada de la tabla.
Salir: Cierra la aplicación.
Diseño ajustable:

Se usan QVBoxLayout y QHBoxLayout para organizar los widgets. Todo es ajustable al 
tamaño de la ventana.
'''

import sys
from PyQt6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QVBoxLayout, QHBoxLayout,
    QLabel, QLineEdit, QPushButton, QTableWidget, QTableWidgetItem, QDateEdit, QMessageBox
)
from PyQt6.QtCore import QDate
from PyQt6.QtGui import QIcon
from PyQt6.QtWidgets import QHeaderView


class VentanaCitas(QMainWindow):
    def __init__(self):
        super().__init__()

        # Configuración de la ventana principal
        self.setWindowTitle("Agendar Cita Médica")
        self.setGeometry(100, 100, 600, 400)

        # Widget principal y layout
        self.central_widget = QWidget()
        self.setCentralWidget(self.central_widget)
        self.layout_principal = QVBoxLayout()
        self.central_widget.setLayout(self.layout_principal)

        # Campos de entrada
        self.crear_campos_entrada()

        # Tabla de citas
        self.crear_tabla()

        # Botones de acción
        self.crear_botones_accion()

    def crear_campos_entrada(self):
        layout_campos = QVBoxLayout()

        # Nombre
        layout_nombre = QHBoxLayout()
        label_nombre = QLabel("Nombre:")
        self.input_nombre = QLineEdit()
        layout_nombre.addWidget(label_nombre)
        layout_nombre.addWidget(self.input_nombre)

        # Apellido
        layout_apellido = QHBoxLayout()
        label_apellido = QLabel("Apellido:")
        self.input_apellido = QLineEdit()
        layout_apellido.addWidget(label_apellido)
        layout_apellido.addWidget(self.input_apellido)

        # Teléfono
        layout_telefono = QHBoxLayout()
        label_telefono = QLabel("Teléfono:")
        self.input_telefono = QLineEdit()
        layout_telefono.addWidget(label_telefono)
        layout_telefono.addWidget(self.input_telefono)

        # Fecha de la cita
        layout_fecha = QHBoxLayout()
        label_fecha = QLabel("Fecha de la cita:")
        self.input_fecha = QDateEdit(calendarPopup=True)
        self.input_fecha.setDate(QDate.currentDate())  # Fecha actual por defecto
        self.input_fecha.setMinimumDate(QDate.currentDate())  # No permite fechas pasadas
        layout_fecha.addWidget(label_fecha)
        layout_fecha.addWidget(self.input_fecha)

        # Añadir todos los layouts al principal
        layout_campos.addLayout(layout_nombre)
        layout_campos.addLayout(layout_apellido)
        layout_campos.addLayout(layout_telefono)
        layout_campos.addLayout(layout_fecha)
        self.layout_principal.addLayout(layout_campos)

    def crear_tabla(self):
        # Crear tabla
        self.tabla = QTableWidget()
        self.tabla.setColumnCount(4)
        self.tabla.setHorizontalHeaderLabels(["Nombre", "Apellido", "Teléfono", "Fecha de Cita"])
        self.tabla.setEditTriggers(QTableWidget.EditTrigger.NoEditTriggers)  # No editable

        # Ajustar el tamaño de las columnas al tamaño de la ventana
        header = self.tabla.horizontalHeader()
        header.setSectionResizeMode(QHeaderView.ResizeMode.Stretch)  # Ajuste automático

        # Añadir la tabla al layout principal
        self.layout_principal.addWidget(self.tabla)

    def crear_botones_accion(self):
        layout_botones = QHBoxLayout()

        # Botón Agregar
        boton_agregar = QPushButton("Agregar Cita")
        boton_agregar.clicked.connect(self.agregar_cita)
        layout_botones.addWidget(boton_agregar)

        # Botón Limpiar
        boton_limpiar = QPushButton("Limpiar Campos")
        boton_limpiar.clicked.connect(self.limpiar_campos)
        layout_botones.addWidget(boton_limpiar)

        # Botón Eliminar
        boton_eliminar = QPushButton("Eliminar Cita")
        boton_eliminar.clicked.connect(self.eliminar_cita)
        layout_botones.addWidget(boton_eliminar)

        # Botón Salir
        boton_salir = QPushButton("Salir")
        boton_salir.clicked.connect(self.close)
        layout_botones.addWidget(boton_salir)

        self.layout_principal.addLayout(layout_botones)

    def agregar_cita(self):
        # Validar que los campos no estén vacíos
        nombre = self.input_nombre.text().strip()
        apellido = self.input_apellido.text().strip()
        telefono = self.input_telefono.text().strip()
        fecha = self.input_fecha.date().toString("yyyy-MM-dd")

        if not nombre or not apellido or not telefono:
            QMessageBox.warning(self, "Campos incompletos", "Por favor, completa todos los campos.")
            return

        # Agregar la cita a la tabla
        fila = self.tabla.rowCount()
        self.tabla.insertRow(fila)
        self.tabla.setItem(fila, 0, QTableWidgetItem(nombre))
        self.tabla.setItem(fila, 1, QTableWidgetItem(apellido))
        self.tabla.setItem(fila, 2, QTableWidgetItem(telefono))
        self.tabla.setItem(fila, 3, QTableWidgetItem(fecha))

        self.limpiar_campos()  # Limpiar campos después de agregar

    def limpiar_campos(self):
        # Limpiar los campos de entrada
        self.input_nombre.clear()
        self.input_apellido.clear()
        self.input_telefono.clear()
        self.input_fecha.setDate(QDate.currentDate())

    def eliminar_cita(self):
        # Obtener la fila seleccionada
        fila_seleccionada = self.tabla.currentRow()
        if fila_seleccionada == -1:
            QMessageBox.warning(self, "Eliminar Cita", "Por favor, selecciona una cita para eliminar.")
            return

        # Eliminar la fila seleccionada
        self.tabla.removeRow(fila_seleccionada)


# Configurar y ejecutar la aplicación
if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaCitas()
    ventana.show()
    sys.exit(app.exec())
