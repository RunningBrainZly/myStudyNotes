
import tensorflow as tf
import pandas as pd
import matplotlib.pyplot as plt
%matplotlib inline



if __name__ == '__main__':
    print('tensorflow version{}'.format(tf.__version__));
    data = pd.read_csv("life/credit-a.csv");
    data.head()
    print(data);





