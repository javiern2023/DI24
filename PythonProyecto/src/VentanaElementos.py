import sys
from PyQt6.QtWidgets import (
    QApplication, QMainWindow, QVBoxLayout, QWidget, QComboBox, QCheckBox,
    QTableWidget, QTableWidgetItem, QLabel
)


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejercicio con ComboBox, CheckBox y Tabla")
        self.setGeometry(100, 100, 600, 400)

        # Crear un widget central y layout principal
        widget_central = QWidget()
        layout = QVBoxLayout(widget_central)

        # Etiqueta
        self.etiqueta = QLabel("Selecciona una categoría:")
        layout.addWidget(self.etiqueta)

        # ComboBox
        self.combo = QComboBox()
        self.combo.addItems(["Tecnología", "Ropa", "Alimentos"])  # Opciones
        self.combo.currentIndexChanged.connect(self.actualizar_tabla)  # Conectar evento
        layout.addWidget(self.combo)

        # CheckBox
        self.checkbox = QCheckBox("Habilitar selección")
        self.checkbox.setChecked(True)  # Activado por defecto
        self.checkbox.stateChanged.connect(self.toggle_combo)  # Conectar evento
        layout.addWidget(self.checkbox)

        # Tabla
        self.tabla = QTableWidget()
        self.tabla.setColumnCount(2)  # Dos columnas
        self.tabla.setHorizontalHeaderLabels(["Producto", "Precio"])  # Encabezados
        self.tabla.setRowCount(0)  # Sin filas iniciales
        layout.addWidget(self.tabla)

        # Configurar el widget central
        self.setCentralWidget(widget_central)

        # Actualizar la tabla por defecto
        self.actualizar_tabla()

    def toggle_combo(self):
        """Habilita o deshabilita el ComboBox según el CheckBox."""
        habilitado = self.checkbox.isChecked()
        self.combo.setEnabled(habilitado)

    def actualizar_tabla(self):
        """Actualiza la tabla en función de la selección del ComboBox."""
        categoria = self.combo.currentText()

        # Datos de ejemplo por categoría
        datos = {
            "Tecnología": [
                ["Laptop", "$800"],
                ["Smartphone", "$600"],
                ["Auriculares", "$50"]
            ],
            "Ropa": [
                ["Camiseta", "$20"],
                ["Pantalón", "$40"],
                ["Zapatillas", "$60"]
            ],
            "Alimentos": [
                ["Manzanas", "$3"],
                ["Pan", "$2"],
                ["Leche", "$1.5"]
            ]
        }

        # Limpiar la tabla antes de actualizar
        self.tabla.setRowCount(0)

        # Agregar filas basadas en la categoría seleccionada
        if categoria in datos:
            for fila, (producto, precio) in enumerate(datos[categoria]):
                self.tabla.insertRow(fila)
                self.tabla.setItem(fila, 0, QTableWidgetItem(producto))
                self.tabla.setItem(fila, 1, QTableWidgetItem(precio))


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())

