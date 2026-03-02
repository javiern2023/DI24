# tabla.py
from PyQt6 import uic
from PyQt6.QtWidgets import QMainWindow, QTableWidgetItem, QMessageBox


class VentanaTabla(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("ui/VentanaTabla.ui", self)

        # Botón salir
        self.btnSalir.clicked.connect(self.close)

        # Botón insertar
        self.pushButton.clicked.connect(self.insertar_datos)

        # Checkboxes exclusivos
        self.checkBox.toggled.connect(lambda checked: self.unico_check(self.checkBox, checked))
        self.checkBox_2.toggled.connect(lambda checked: self.unico_check(self.checkBox_2, checked))
        self.checkBox_3.toggled.connect(lambda checked: self.unico_check(self.checkBox_3, checked))

    # Hace que solo se pueda marcar un checkbox
    def unico_check(self, checkbox, checked):
        if checked:
            for cb in [self.checkBox, self.checkBox_2, self.checkBox_3]:
                if cb != checkbox:
                    cb.setChecked(False)

    # Insertar datos en la tabla
    def insertar_datos(self):

        # Recoger datos
        id_text = self.leID.text().strip()
        usuario = self.leUsuario.text().strip()
        password = self.lePass.text().strip()

        # Obtener ciclo seleccionado
        ciclo = ""

        if self.checkBox.isChecked():
            ciclo = "DAM"
        elif self.checkBox_2.isChecked():
            ciclo = "DAW"
        elif self.checkBox_3.isChecked():
            ciclo = "ASIR"

        # Validación: todos los campos obligatorios
        if not id_text or not usuario or not password or not ciclo:
            QMessageBox.warning(self, "Error", "Todos los campos deben estar rellenos")
            return

        # Insertar nueva fila al final
        fila = self.tableWidget.rowCount()
        self.tableWidget.insertRow(fila)

        self.tableWidget.setItem(fila, 0, QTableWidgetItem(id_text))
        self.tableWidget.setItem(fila, 1, QTableWidgetItem(usuario))
        self.tableWidget.setItem(fila, 2, QTableWidgetItem(password))
        self.tableWidget.setItem(fila, 3, QTableWidgetItem(ciclo))

        # Limpiar campos después de insertar
        self.leID.clear()
        self.leUsuario.clear()
        self.lePass.clear()

        self.checkBox.setChecked(True)
        self.checkBox_2.setChecked(False)
        self.checkBox_3.setChecked(False)