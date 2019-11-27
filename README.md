#### MVVM Demo using LiveData & ViewModel
 
The main purpose of this app is to show MVVM sample implementation using the new Google Architectural components LiveData and ViewModel.

Fetching images from https://pixabay.com and showing on gridview. Using MVVM architecture, Recylerview, Retrofit & Kotlin,LiveData & ViewModel

#### Demo

<table>
  <td>
    <p align="center">
  <img src="https://user-images.githubusercontent.com/10658016/65840821-f0daf300-e33a-11e9-8893-e4f2adbb6c5a.png?raw=true" alt="Home Page" width="300"/>
</p>
</td>
<td>
    <p align="center">
  <img src="https://user-images.githubusercontent.com/10658016/65840822-f20c2000-e33a-11e9-9e6c-edf14672f1da.png?raw=true" alt="Movie Details" width="300"/>
    </p>
  </td>

</table>

#### Application Architecture
![alt text](https://cdn-images-1.medium.com/max/1600/1*OqeNRtyjgWZzeUifrQT-NA.png)

The main advatage of using MVVM, there is no two way dependency between ViewModel and Model unlike MVP. Here the view can observe the datachanges in the viewmodel as we are using LiveData which is lifecycle aware. The viewmodel to view communication is achieved through observer pattern (basically observing the state changes of the data in the viewmodel).

#### Dependencies

```
def retrofit_version = "2.6.2";
def glide_version = "4.10.0";
def lifecycle_ex_version = "2.1.0";

// Lifecycle components
implementation "com.github.bumptech.glide:glide:$glide_version"
annotationProcessor "com.github.bumptech.glide:compiler:$glide_version"

implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    
implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_ex_version"

```

#### Using Jetpack Architecture Components
* LiveData
* ViewModel

#### Key Points

- ViewModel request the information from the model replies with observable, ViewModel updates all the local properties inside the ViewModel.
- Model doesn’t call directly ViewModels
- ViewModel doesn’t talk directly to any one of the components, this causes huge separation between the View and Model



