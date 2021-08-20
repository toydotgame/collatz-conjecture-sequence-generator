# Collatz Sequence Generator
This is a simple program that I made as a proof of concept and simple introduction to the Collatz Conjecture (also known as _the 3x+1 Problem_).

## Use
### Requirements
* Java (>= 1.8.0\_292)

### Running
Download a JAR from the [_Releases_](https://github.com/toydotgame/collatz-conjecture-sequence-generator/releases) section, open a terminal in your download directory, and run this:
```sh
java -jar Collatz.jar
```

### Configuration
There are three options available currently:
Option Name | Options | Description
----------- | ------- | -----------
Show calculation steps? | `y` or `n` | Show each individual number in the sequence of numbers calculated. If `n` is chosen, stats will be shown at the end about sequence length, and numbers of odd and even numbers.
Print equations? | `y` or `n` | If a number is odd, `3 * x + 1 = y` is printed; and if even `x / 2 = y` is printed. The equations printed may differ from how the numbers themselves are internally calculated, but both the output and the internals of this program follow the rules of the Collatz Conjecture exactly.
Say if a number is odd or even? | `y` or `n` | Adds a prefix to the start of each line saying the odd/evenness of the previous number, and the new number that has been calculated \[according to the rules\].
