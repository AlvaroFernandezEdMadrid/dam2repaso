import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from datetime import datetime

def calcular_media():
    try:
        notas = [
            float(entry_nota1.get()), 
            float(entry_nota2.get()), 
            float(entry_nota3.get()), 
            float(entry_nota4.get())
        ]
        media = sum(notas) / len(notas)
        entry_media.delete(0, tk.END)  # Limpiar campo de media
        entry_media.insert(0, f"{media:.2f}")  # Mostrar la media calculada
    except ValueError:
        messagebox.showerror("Error", "Por favor, ingrese valores numéricos válidos en las notas.")


def guardar_datos():
    nombre = entry_nombre.get()
    apellidos = entry_apellidos.get()
    curso = entry_curso.get()
    grupo = entry_grupo.get()
    tutor = entry_tutor.get()
    media = entry_media.get()
    fecha = entry_fecha.get()

    if not all([nombre, apellidos, curso, grupo, tutor, media, fecha]):
        messagebox.showwarning("Advertencia", "Por favor, complete todos los campos.")
    else:
        # Aquí podrías hacer lo que quieras con los datos (guardar en una base de datos, archivo, etc.)
        print(f"Nombre: {nombre}")
        print(f"Apellidos: {apellidos}")
        print(f"Curso: {curso}")
        print(f"Grupo: {grupo}")
        print(f"Notas: {entry_nota1.get()}, {entry_nota2.get()}, {entry_nota3.get()}, {entry_nota4.get()}")
        print(f"Tutor: {tutor}")
        print(f"Media: {media}")
        print(f"Fecha: {fecha}")
        messagebox.showinfo("Información", "Datos guardados correctamente.")

# Crear la ventana principal
root = tk.Tk()
root.title("Formulario de Datos del Usuario")

# Crear el contenedor del formulario
frame = ttk.Frame(root, padding="20")
frame.grid(row=0, column=0, sticky=(tk.W, tk.E, tk.N, tk.S))

# Etiquetas y campos de entrada
ttk.Label(frame, text="Nombre").grid(row=0, column=0, sticky=tk.W, pady=5)
entry_nombre = ttk.Entry(frame)
entry_nombre.grid(row=0, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Apellidos").grid(row=1, column=0, sticky=tk.W, pady=5)
entry_apellidos = ttk.Entry(frame)
entry_apellidos.grid(row=1, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Curso").grid(row=2, column=0, sticky=tk.W, pady=5)
entry_curso = ttk.Entry(frame)
entry_curso.grid(row=2, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Grupo").grid(row=3, column=0, sticky=tk.W, pady=5)
entry_grupo = ttk.Entry(frame)
entry_grupo.grid(row=3, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Nota 1").grid(row=4, column=0, sticky=tk.W, pady=5)
entry_nota1 = ttk.Entry(frame)
entry_nota1.grid(row=4, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Nota 2").grid(row=5, column=0, sticky=tk.W, pady=5)
entry_nota2 = ttk.Entry(frame)
entry_nota2.grid(row=5, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Nota 3").grid(row=6, column=0, sticky=tk.W, pady=5)
entry_nota3 = ttk.Entry(frame)
entry_nota3.grid(row=6, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Nota 4").grid(row=7, column=0, sticky=tk.W, pady=5)
entry_nota4 = ttk.Entry(frame)
entry_nota4.grid(row=7, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Tutor").grid(row=8, column=0, sticky=tk.W, pady=5)
entry_tutor = ttk.Entry(frame)
entry_tutor.grid(row=8, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Fecha (YYYY-MM-DD)").grid(row=9, column=0, sticky=tk.W, pady=5)
entry_fecha = ttk.Entry(frame)
entry_fecha.grid(row=9, column=1, sticky=(tk.W, tk.E), pady=5)

ttk.Label(frame, text="Media").grid(row=10, column=0, sticky=tk.W, pady=5)
entry_media = ttk.Entry(frame)
entry_media.grid(row=10, column=1, sticky=(tk.W, tk.E), pady=5)

# Botones
ttk.Button(frame, text="Calcular Media", command=calcular_media).grid(row=11, column=0, columnspan=2, pady=10)
ttk.Button(frame, text="Guardar Datos", command=guardar_datos).grid(row=12, column=0, columnspan=2, pady=10)

# Ejecutar la interfaz
root.mainloop()
