package com.sb2318.netclanclone.services

object DataService {

    fun getPersonData(): MutableList<DataModel> {

        val datas = mutableListOf<DataModel>()

        val model1= DataModel(
            "Anjana Bhoumik",
                 "Jaipur",
                   1000,
                   20,
            listOf("Coffee","Business","Friendship"),
            2,
            "",
            "IBM",
               "Available"
        )

        val model2 = DataModel(
             "Pranisha Tamang",
            "Siliguri",
            32900,
            40,
            listOf("Coffee","Business","Friendship","Hobbies","Movies","Dinning"),
            1,
            "",
            "Siliguri Consultancy",
               "Busy"

        )

        val model3= DataModel(
            "Arghadeep Bandya",
            "Kolkata",
            33700,
            60,
            listOf("Business"),
            3,
            "",
            "IT Services and Consulting",
            "Sleeping"
        )

        val model4= DataModel(
             "Sagar Sarkar",
            "Siliguri",
            36600,
            30,
            listOf("Coffee","Business","Hobbies","Friendship","Movies"),
            2,
            "",
            "Technology Consultant",
                ""
        )

        datas.add(model1)
        datas.add(model2)
        datas.add(model3)
        datas.add(model4)

        return datas

    }

    fun getNearByPersonData(): MutableList<DataModel> {

        val datas = mutableListOf<DataModel>()

        val model1 = DataModel(
            "Pranisha Tamang",
            "Siliguri",
            32900,
            40,
            listOf("Coffee","Business","Friendship","Hobbies","Movies","Dinning"),
            1,
            "",
            "Siliguri Consultancy",
            "Busy"

        )

        val model2= DataModel(
            "Sagar Sarkar",
            "Siliguri",
            36600,
            30,
            listOf("Coffee","Business","Hobbies","Friendship","Movies"),
            2,
            "",
            "Technology Consultant",
            ""
        )

        datas.add(model1)
        datas.add(model2)

        return datas;

    }

    fun getCompaniesData(): MutableList<DataModel> {

        val datas= mutableListOf<DataModel>()

        val model1 = DataModel(
            "North Bengal & Sikkim Taxi Service",
            "Siliguri",
            31500,
            70,
            listOf(),
            0,
            "Car Rental Agency",
            "",
            ""
        )

        val model2= DataModel(
             "Baba Lokenath Medical Stores",
             "Siliguri",
             31800,
            50,
            listOf(),
            0,
            "Pharmacy",
            "",
            ""

        )

        val model3 = DataModel(
            "The Shining Entertainment Group",
            "Siliguri",
            32600,
            80,
            listOf(),
            0,
            "Wedding Planner",
            "",
            ""
        )

        val model4= DataModel(
             "Maa Electric and Decorator",
              "Siliguri",
            32600,
                80,
            listOf(),
            0,
            "Event Management",
            "",
            ""

        )

        datas.add(model1)
        datas.add(model2)
        datas.add(model3)
        datas.add(model4)

        return datas
    }


}

fun processDistance(distance:Long):Double{

    return if(distance>= 1000)
            distance/1000.0
           else
               distance/1.0
}