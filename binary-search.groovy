def nl = [1,2,6,7,12,0,3,4]
def nlSize = nl.size()
def nlMidPt = nl.size() / 2
println(nl.sort())
println("list contents: " + nl)
println("list size: " + nlSize)
println("list approx mid pt: " + nlMidPt)
println(nlMidPt)

print("Target Number: ")
userInput = System.console().readLine() as Integer

println("You entered: $userInput")

if(nl[nlMidPt] == userInput) {
    println("Target found")
} else {
    if (nl[nlMidPt] > userInput) {
        println('''go to right''' + userInput + '''  ''')

    } else {
        println('''go to left''' + userInput + '''  ''')
    }
    // for(int i in nl) {
    //     println(i)
    // }
}
