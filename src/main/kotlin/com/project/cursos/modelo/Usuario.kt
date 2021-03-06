package com.project.cursos.modelo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var nome: String? = null
    var email: String? = null
    var senha: String? = null

    constructor() {}
    constructor(nome: String?, email: String?, senha: String?) : super() {
        this.nome = nome
        this.email = email
        this.senha = senha
    }

    constructor(nome: String?, email: String?, senha: String?, id: Long?) : super() {
        this.nome = nome
        this.email = email
        this.senha = senha
        this.id = id
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (id == null) 0 else id.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Usuario
        if (id == null) {
            if (other.id != null) return false
        } else if (id != other.id) return false
        return true
    }
}

