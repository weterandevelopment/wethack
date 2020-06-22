# WetHack

WetHack is a Minecraft Forge Mod Base used to teach Beginners the Basics of a Custom Base.

## Installation

### Clone

Clone the repository using [Github Desktop](https://desktop.github.com/) or download it as a zip onto your machine.

### Opening the Project

To open the project in IntelliJ click on File > Open and select the wethack repository folder.
IntelliJ should now automatically start importing the Gradle Project. Once its finished, continue to the next step

### Setting up the development environment

You will see a little taskbar on the right of your screen, with the Gradle Tab on it. Click on it to expand it, and locate the task "setupDecompWorkspace" in the "forgegradle" directory. Double click it to run.

#### Setting up the Application

Now run the task "genIntelliJRuns" also in the "forgegradle" directory. After that click on here:

![edit-configurations](https://i.konasclient.com/kbqylui1.png)

Now click on the "Minecraft Client" Application and set the "Use classpath of module:" property to "wethack.main" using the dropdown. Once you're done click "Ok" to save your changes. Now you can run Minecraft in IntelliJ using the play button shown in the picture above.


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
[GPL-v3](https://www.gnu.org/licenses/gpl-3.0.en.html)
