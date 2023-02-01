#!/usr/bin/env python
# coding: utf-8

# In[6]:


import pandas as pd
import string


# In[7]:


data=pd.read_csv("/Users/berkaykazkilinc/Desktop/yazlab2/rows.csv")


# In[8]:


data.drop(['Sub-product','Date received','Sub-issue','Consumer complaint narrative','Company public response','Tags','Consumer consent provided?','Submitted via','Date sent to company','Company response to consumer','Timely response?','Consumer disputed?'], axis=1 , inplace=True)


# In[9]:


data=data.dropna() #null veriler kaldırıldı


# In[10]:


#noktalama isareti kaldirma
def remove_punctuation(txt):
    txt_nopunc = "".join([c for c in txt if c not in string.punctuation])
    return txt_nopunc


# In[19]:


data['Company'] = data['Company'].apply(lambda x : remove_punctuation(x))
data['Issue'] = data['Issue'].apply(lambda x : remove_punctuation(x))
data['Product'] = data['Product'].apply(lambda x : remove_punctuation(x))


# In[13]:


#stop word kaldırma
import nltk
nltk.download('stopwords')
from nltk.corpus import stopwords
",".join(stopwords.words('english'))
stop_words=set(stopwords.words('english'))


# In[14]:


def remove_stop(x):
    return " ".join([word for word in str(x).split() if word not in stop_words])


# In[17]:


data['Issue']=data['Issue'].apply(lambda x : remove_stop(x))
data['Product']=data['Product'].apply(lambda x : remove_stop(x))


# In[20]:


data


# In[ ]:




