package practica12

import auth.Usuario

class BootStrap {

    def init = { servletContext ->


        if (Usuario.count() < 1){

            def admin = new Usuario(username: "admin", password: "admin")
            admin.save(flush: true, failOnError: true)
        }
        if (Categoria.count() < 1){

            def categoria1 = new Categoria(nombre: "Normal", usuario: Usuario.first())
            def categoria2 = new Categoria(nombre: "Importante", usuario: Usuario.first())
            def categoria3 = new Categoria(nombre: "Bajo", usuario: Usuario.first())

            categoria1.save(flush: true, failOnError: true)
            categoria2.save(flush: true, failOnError: true)
            categoria3.save(flush: true, failOnError: true)
        }

        if (Contacto.count() < 1){

            def contacto = new Contacto(nombre: "Ansel", apellido: "Corona", puesto: "Manager", telefono: "8295464950", direccion: "Paseo de Los Samanes #3", categorias: [Categoria.first()], email: "anselcorona@gmail.com", movil: "8094014950", usuario: Usuario.first())

            contacto.save(flush:true, failOnError: true)
        }



    }


    def destroy = {
    }
}
