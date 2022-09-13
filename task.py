import os
os.system("pip3 install -r requirements.txt")


from tensorflow import keras
import numpy as np
import joblib
import sklearn

import sys

a1 = sys.argv.pop()
a2 = sys.argv.pop()
a3 = sys.argv.pop()
a4 = sys.argv.pop()
a5 = sys.argv.pop()
a6 = sys.argv.pop()
a7 = sys.argv.pop()
a8 = sys.argv.pop()

scaler = joblib.load('scaler.gz')
model = keras.models.load_model('task.h5')
data = np.array([a1,a2,a3,a4,a5,a6,a7,a8])
data = data.reshape([1,8])
data = scaler.transform(data)
result = model.predict(data)
r = np.argmax(result)
if r==0:
    print(2)
elif r == 1:
    print(4)
else:
    print(80)