fun main(args: Array<String>) {
  val game1 = Game(5)   
  game1.Start()
   
}

//клас игра, в котором есть конструктор, принимающий ко-во игр
class Game(var countGames:Int){
   private var name1:String = "Вася"  //имя первого игрока
   private var name2:String = "Маша"  //имя второго игрока
   private var from:Int = 0              //игрок загадывает и отгадывает число с этой позиции
   private var to:Int = 100               //игрок загадывает и отгадывает число до этой позиции
   private var inventedNumber = 0        //число, которое загадал игрок
   private var name1Invent = true        //если эта переменная true, значит первый игрок загадывает
   private var attemps = 10              //количество возможных попыток
   private var currentAttempt = 0        //текущее число уже сделанных попыток
   private var curentCountGame = 0       //текущая по счету игра
   
    //метод 
    public fun Start(){ 
       currentAttempt = 0 
       curentCountGame++               //увеличиваем счетчик игры
       println()
       println("игра номер $curentCountGame")
       inventedNumber = RandomNumber() //игрок загадывает число
       
       var player1:String = "" //этот игрок загадывает число
       var player2:String = "" //этот игрок отгадывает число
       
       if(name1Invent==true){
          player1 = name1 
          player2 = name2 
       }   
       else{
          player1 = name2 
          player2 = name1 
       } 
             
       currentGame(player1, player2)
   }
   
   //игра
   private fun currentGame(player1:String, player2:String){      
       println("Игрок $player1 загадал число $inventedNumber") 
       guessNumber(player1,player2)
       
   } 
   
   //ф-ция отгадывания числа
   private fun guessNumber(player1:String, player2:String){
       currentAttempt++  //увеличиваем ко-во попыток отгадываний
       var number:Int = RandomNumber()
       println("$player2: $number")
       
       if(number == inventedNumber && currentAttempt <= attemps){     //если угадал и ко-во попыток не израсходовал
           println("$player2 выиграл!")           
           if(player1 == name1) name1Invent = false else name1Invent = true           
           if(curentCountGame < countGames) Start() else println("хватит играть!")
       } 
       else if(number != inventedNumber && currentAttempt >= attemps){  //если не угадал и ко-во попыток израсходовал
           println("$player2 проиграл!")
           if(player1 == name1) name1Invent = true else name1Invent = false
         if(curentCountGame < countGames) Start() else println("хватит играть!")
       }
       else if(number != inventedNumber && currentAttempt < attemps ){
           if(number < inventedNumber) println("загаданное число больше") else 
                                       println("загаданное число меньше")
           guessNumber(player1, player2)                               //если не угадал, но попытки еще остались
       }   
       
   }
   
   //ф-ция рандомно подбирает число в промежудке между 
   //первым и вторым числами и возвращает его
   private fun RandomNumber(): Int{
       return (from..to).random()        
   }  
  
}
