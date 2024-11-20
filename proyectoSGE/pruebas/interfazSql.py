from tkinter import Tk, W, Toplevel, Text
from tkinter import ttk
import mysql.connector

conn = None

ventana = Tk()
ventana.title("SQL")

lbUser = ttk.Label(ventana, text="User: ")
lbUser.grid(column=0, row=0, sticky=W)
user = ttk.Entry(ventana)
user.grid(column=1, row=0)

lbPassword = ttk.Label(ventana, text="Password: ")
lbPassword.grid(column=0, row=1, sticky=W)
password = ttk.Entry(ventana)
password.grid(column=1, row=1)

lbHost = ttk.Label(ventana, text="Host: ")
lbHost.grid(column=0, row=2, sticky=W)
host = ttk.Entry(ventana)
host.grid(column=1, row=2)


def conectarBD():
    global conn

    conn = mysql.connector.connect(
        user=user.get(), password=password.get(), host=host.get()
    )

    if conn.is_connected():
        cursor = conn.cursor()
        cursor.execute("SHOW DATABASES LIKE 'BBDDPRUEBA';")
        result = cursor.fetchone()

        if not result:
            cursor.execute("CREATE DATABASE BBDDPRUEBA;")

        crearVentanaHija()

        cursor.close()
    else:
        print("No se pudo establecer la conexión al servidor MySQL.")


def crearVentanaHija():
    ventanaHija = Toplevel(ventana)
    ventanaHija.title("Consultas a la Base de Datos")

    lbMensaje = ttk.Label(
        ventanaHija, text="Conexión exitosa. Puedes realizar consultas.", padding=20
    )
    lbMensaje.grid(column=0, row=0)

    lbConsulta = ttk.Label(ventanaHija, text="Escribe tu sentencia SQL:")
    lbConsulta.grid(column=0, row=1, sticky=W)

    consulta = ttk.Entry(ventanaHija, width=50)
    consulta.grid(column=1, row=1)

    resultText = Text(ventanaHija, height=10, width=50)
    resultText.grid(column=1, row=2, pady=10)

    def ejecutarConsulta():
        query = consulta.get()
        if query.strip():
            ejecutarSQL(query, resultText)

    btnEjecutar = ttk.Button(
        ventanaHija, text="Ejecutar consulta", command=ejecutarConsulta
    )
    btnEjecutar.grid(column=1, row=3)


def ejecutarSQL(query, resultText):
    global conn
    if conn is None:
        resultText.delete(1.0, "end")
        resultText.insert("end", "No hay conexión a la base de datos.")
        return

    conn.database = "BBDDPRUEBA"
    cursor = conn.cursor()
    cursor.execute(query)

    if query.strip().lower().startswith("select"):
        rows = cursor.fetchall()
        resultText.delete(1.0, "end")
        for row in rows:
            resultText.insert("end", str(row) + "\n")
    else:
        resultText.delete(1.0, "end")
        resultText.insert("end", "Consulta ejecutada correctamente.")

    cursor.close()


btnConnect = ttk.Button(ventana, text="Conectar", command=conectarBD)
btnConnect.grid(column=0, row=3)

ventana.mainloop()
