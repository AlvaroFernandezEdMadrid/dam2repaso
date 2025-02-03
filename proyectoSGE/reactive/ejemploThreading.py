import tkinter as tk
import random
import time
import threading

def esperar_segundos():
    label.config(text="Hilo con espera iniciado...")
    time.sleep(5)  
    label.config(text="Han pasado los segundos")

def calcular_aleatorio():
    numero_aleatorio = random.randint(1, 100)
    label.config(text=f"Numero aleatorio: {numero_aleatorio}")

root = tk.Tk()
root.title("Hola Mundo")
root.geometry("500x400")

boton_esperar = tk.Button(root, text="Esperar", command=lambda:threading.Thread(target=esperar_segundos).start())
boton_esperar.pack(pady=20)

boton_calcular = tk.Button(root, text="Calcular Aleatorio", command=calcular_aleatorio)
boton_calcular.pack(pady=20)

label = tk.Label(root, text="Cositas", font=("Arial", 14))
label.pack(pady=20)

root.mainloop()
