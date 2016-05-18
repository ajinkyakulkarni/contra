# Contra #

Contra is a a programming language that I wrote from scratch
while I was writing my book
[Practical Interpreter Construction](https://leanpub.com/pic)

Contra is ideal for studying interpreter construction that it has
tokenizer, parser and interpreter. I consciously keep it simple
to make my book's readers able to understand the internals.

## Example Application ##

There is a simple expense management application in sample folder.
Have a look expense-add.con and expense-report.con scripts in sample folder.

Here is an example output:

```
 WEEKLY EXPENSE REPORT
======================
Total      Week   Year
29913      10     2014
29913      13     2014
210625     22     2014
29913      2      2015
31157      22     2015
387        24     2015
29299      25     2015
29913      26     2015
======================
```

## Features ##

It is the 1.0 version.

* Expressions
* Numbers
* Strings
* Variables
* Code Blocks
* While Loop
* If-Else Construct
* Arrays
* Functions
* Inline Functions
* Code Comments
* MySQL Insert and Update Query
* MySQL Select Query

Inline Methods:

* print
* println
* wait
* split
* readln
* dbInsertQuery
* dbSelectQuery

These inline functions are the ones I used in demo scripts along the book.

## License ##

Contra has MIT licensed. That means you can use it for either non-commercial
or commercial purposes.
Check out the LICENSE.md for full license.

## Author ##

Mehmet Emin Coskun. mehmetcoskun@fastmail.com

You can send me your thoughts and/or feedback/fixes if you like to. I can't promise
to answer all emails but I will try.
