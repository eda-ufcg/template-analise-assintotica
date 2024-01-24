library('ggplot2')
data = read.table('sort.data', header = T)
ggplot(data, aes(x = sample, y = time, colour = alg)) + geom_line()
