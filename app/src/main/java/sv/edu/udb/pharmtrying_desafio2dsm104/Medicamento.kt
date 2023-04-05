package sv.edu.udb.pharmtrying_desafio2dsm104

class Meds {
    fun key(key:String?){
    }
    var name:String?=null
    var price:Float?=null
    var indications:String?=null
    var contraindications:String?=null
    var med:MutableMap<String,Boolean> = HashMap()

    constructor(){}
    constructor(name:String?,price:Float?,indications:String?,contraindications:String?){
        this.name = name
        this.price = price
        this.indications = indications
        this.contraindications = contraindications
    }
}