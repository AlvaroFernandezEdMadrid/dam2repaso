'''
Created on 23 oct 2024

@author: usertar
'''

import tkinter as tk
from tkinter import ttk
from _ast import If

ventana = tk.Tk()
ventana.title("VentanaPadre")



def activarBoton():
    btnHija.configure(state="normal")


texto = tk.StringVar(ventana) 
    
desplegable=ttk.Combobox(ventana, values=("uno","dos","tres","cuatro"))
desplegable.grid(column=0, row=4) 
texto.set(desplegable.get())  


entry = tk.Entry(ventana, textvariable=texto, validate="key", validatecommand=activarBoton)
entry.grid(column=1, row=0)
entry.focus()

entry2 = tk.Entry(ventana)
entry2.grid(column=3, row=2)

dondeW = (ventana.winfo_screenwidth() / 2) - (854 / 2)
dondeH = (ventana.winfo_screenheight() / 2) - (480 / 2)


def abrirHija():
    secundaria = tk.Toplevel(ventana)
    secundaria.title("VentanaHija")
    secundaria.geometry(f'854x480+{int(dondeW)}+{int(dondeH)}')
    btnQuitar = ttk.Button(secundaria, text="CerrarVentana", command=secundaria.destroy)
    btnQuitar.grid(column=0, row=0)   
    lblHija = ttk.Label(secundaria, text="Hola " + texto.get())
    lblHija.grid(column=0, row=2)
    

btnHija = ttk.Button(ventana, text="Pulsa Aqui", command=abrirHija, state="disabled")
btnHija.grid(column=0, row=0)

ventana.geometry(f'854x480+{int(dondeW)}+{int(dondeH)}')

ventana.mainloop()
