# Excluimos las licencias duplicadas
Excluimos:

```
packagingOptions {
        exclude 'META-INF/ASL2.0'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/license.txt'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/notice.txt'
    }

```

# Agregamos las dependencias de Retrofit

```
//Las siguientes dependencias son las usadas para retrofit en android
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-jackson:2.5.0'


```
# Agregamos los permisos de internet
```
<uses-permission android:name="android.permission.INTERNET"/>
```

# Agregamos las interfaces de los repositorios de nuestras entidades


