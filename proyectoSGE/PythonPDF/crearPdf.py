import jinja2
import pdfkit

def crear_pdf(ruta_template, info, rutacss=''):
    nombre_template = ruta_template.split('/')[-1]
    ruta_template = ruta_template.replace(nombre_template,'')
    
    env = jinja2.Environment(loader=jinja2.FileSystemLoader(ruta_template))
    template = env.get_template(nombre_template)
    html = template.render(info)
    
    print(html)
    #nombre, apellidos, curso, grupo, 4 notas, tutor, media y fecha
    options = {
        'page-size': 'letter',
        'margin-top': '0.05in',
        'margin-bottom': '0.05in',
        'margin-right': '0.05in',
        'margin-left': '0.05in',
        'encoding': 'UTF-8'
    }
    config = pdfkit.configuration(wkhtmltopdf='/usr/bin/wkhtmltopdf')
    
    ruta_salida = '/home/usertar/Escritorio/PruebaMario-Borrar/ficher.pdf'
    
    pdfkit.from_string(html, ruta_salida, css=rutacss, options=options, configuration=config)
    
if __name__ == '__main__':
    ruta_template = '/home/usertar/Escritorio/PruebaMario-Borrar/template.html'
    info = {"nombreAlumno": "Álvaro"}
    rutacss='/home/usertar/Escritorio/PruebaMario-Borrar/estilos.css'
    crear_pdf(ruta_template, info, rutacss)
