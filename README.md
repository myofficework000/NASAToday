# Astronomy Picture of the Day

## Build Instructions

Add an NASA Developer API key in `~/.gradle/gradle.properties` (Linux) with variable name `NasaApodDevKey`.

	~/.gradle/gradle.properties
	NasaApodDevKey="YOUR API KEY"
	
## Notes

 * Unsuccessful responses like errors are discarded for now. For example, the app will allow you 
   to select current date but it may not have an entry in the Apod database and this result would
   be discarded for now.
 * When the app is started the data for the current date is downloaded automatically once a day.
 * I have decided not to download data which contains videos instead of an image. Some days may
   have videos which will not be saved in the database.
 * The calendar button will always re-download the data for the requested date. It is an 
   intentional feature.

## Screenshots

<img src="https://raw.githubusercontent.com/sudhirkhanger/apod/master/art/device-2019-08-01-093128.png" width="50%"><img src="https://raw.githubusercontent.com/sudhirkhanger/apod/master/art/device-2019-08-01-093215.png" width="50%">

<p align="center">
<img src="https://raw.githubusercontent.com/sudhirkhanger/apod/master/art/device-2019-08-01-093630.png">
</p>
	
## License

    Copyright 2019 Sudhir Khanger

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
