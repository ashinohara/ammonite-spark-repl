# ammonite-spark-repl

This repo is an easy way to bootstrap a local spark repl using [ammonite-spark](https://github.com/alexarchambault/ammonite-spark)
## Installation
1. Install ammonite with scala 2.12  `./install.sh`  
    
2. Install start the repl `./repl.sh`

3. Test some spark code

```
val df = Seq(
    (8, "bat"),
    (64, "mouse"),
    (-27, "horse")
  ).toDF("number", "word")
df.show()
```


