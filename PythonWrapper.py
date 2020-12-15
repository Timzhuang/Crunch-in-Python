from py4j.java_gateway import JavaGateway, CallbackServerParameters
import sys
import cProfile

gateway = JavaGateway(callback_server_parameters=CallbackServerParameters())


class MemPipeline(object):
    def __init__(self):
        global gateway
        self.gateway = gateway
        self.pipeline = gateway.jvm.src.main.java.CS239.crunch.MemPipelineEntryPoint.getInstance()

    def readTextFromFile(self, inputPath):
        p_col = gateway.jvm.src.main.java.CS239.crunch.MemPipelineEntryPoint.readTextFromFileWrapper(
            self.pipeline, inputPath)
        return PCollection(p_col)

    def writeToFile(self, outputTable, outputPath):
        gateway.jvm.src.main.java.CS239.crunch.MemPipelineEntryPoint.writeToFile(
            outputTable.exposePTable(), outputPath)

    def done(self):
        gateway.jvm.src.main.java.CS239.crunch.MemPipelineEntryPoint.done(
            self.pipeline)


class PCollection(object):
    def __init__(self, pcol):
        global gateway
        self.gateway = gateway
        self.pcol = pcol

    def count(self):
        p_table = gateway.jvm.src.main.java.CS239.crunch.PCollection_.count(
            self.pcol)
        return PTable(p_table)

    def tokenize(self):

        p_col_2 = gateway.jvm.src.main.java.CS239.crunch.PCollection_.tokenize(
            self.pcol)
        return PCollection(p_col_2)


class PTable(object):
    def __init__(self, ptable):
        global gateway
        self.gateway = gateway
        self.ptable = ptable

    def exposePTable(self):

        return self.ptable


def wordcount_example(inputPath, outputPath):
    pipeline = MemPipeline()
    lines = pipeline.readTextFromFile(inputPath)
    words = lines.tokenize()
    word_count = words.count()
    pipeline.writeToFile(word_count, outputPath)
    pipeline.done()


def word_count_profile():

    file_size = 1
    prefix = "/Users/ishaanpota/Desktop/ugh/"
    inputPaths = [prefix + "data/benchmark" +
                  str(3) + ".txt" for i in range(1, file_size+1)]
    outputPaths = [prefix + "output/word_count_output3_python" +
                   str(3) for i in range(1, file_size+1)]

    # profiling execution time
    for i in range(file_size):
        cProfile.runctx(
            'f(x, y)', {'f': wordcount_example, 'x': inputPaths[i], 'y': outputPaths[i]}, {})

    # profiling memory usage


def main():
    word_count_profile()
    print("here")
    gateway.close_callback_server()


if __name__ == '__main__':
    main()
