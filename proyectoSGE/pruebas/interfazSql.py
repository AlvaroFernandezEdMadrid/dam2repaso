from tkinter import Tk, W
from tkinter import ttk
import mysql.connector

ventana= Tk()
ventana.title("SQL")

conn=mysql.connector.connect(user="root", password="123456789", host="172.17.0.2")
print(conn)
lbUser=ttk.Label(ventana, text="User: ")
lbUser.grid(column=0, row=0, sticky=W)
user=ttk.Entry(ventana)
user.grid(column=1, row=0)

lbPassword=ttk.Label(ventana, text="Password: ")
lbPassword.grid(column=0, row=1, sticky=W)
password=ttk.Entry(ventana)
password.grid(column=1,row=1)

lbHost=ttk.Label(ventana, text="Host: ")
lbHost.grid(column=0, row=2, sticky=W)
host=ttk.Entry(ventana)
host.grid(column=1,row=2)

ventana.mainloop()

