import tkinter as tk
import pdfkit
import os

def get_form_data():
    # Recoger los datos del formulario
    nombre = entry_nombre.get()
    correo = entry_correo.get()
    
    # Llamar a la función que genera el PDF
    generate_pdf(nombre, correo)

def generate_pdf(nombre, correo):
    # Especificar correctamente la ruta al ejecutable de wkhtmltopdf
    config = pdfkit.configuration(wkhtmltopdf=r'C:\Program Files\wkhtmltopdf\bin\wkhtmltopdf.exe')  # Usando cadena cruda
    
    # Obtener la ruta del directorio donde se encuentra el script
    current_dir = os.path.dirname(os.path.abspath(__file__))  # Obtiene el directorio actual
    
    # Construir la ruta completa al archivo template.html en el mismo directorio
    template_path = os.path.join(current_dir, 'template.html')
    
    # Leer el archivo de plantilla HTML
    try:
        with open(template_path, "r") as file:
            html_template = file.read()
    except FileNotFoundError:
        print(f"El archivo 'template.html' no se encuentra en el directorio: {current_dir}")
        return

    # Reemplazar los marcadores de posición con los datos del formulario
    html_content = html_template.replace("{{nombre}}", nombre).replace("{{correo}}", correo)
    
    # Usar pdfkit para generar el PDF directamente desde el contenido HTML
    pdfkit.from_string(html_content, "output.pdf", configuration=config)
    
    print("PDF generado exitosamente.")

# Crear la ventana principal
root = tk.Tk()
root.title("Formulario")

# Crear las etiquetas y campos de entrada
label_nombre = tk.Label(root, text="Nombre:")
label_nombre.pack()
entry_nombre = tk.Entry(root)
entry_nombre.pack()

label_correo = tk.Label(root, text="Correo electrónico:")
label_correo.pack()
entry_correo = tk.Entry(root)
entry_correo.pack()

# Crear el botón que recoja los datos y genere el PDF
button_generar_pdf = tk.Button(root, text="Generar PDF", command=get_form_data)
button_generar_pdf.pack()

# Ejecutar la aplicación
root.mainloop()
