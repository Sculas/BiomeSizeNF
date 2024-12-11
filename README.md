# BiomeSizeNF

Simple [NeoForge](https://neoforged.net) mod to adjust the biome size for Minecraft version `1.21.1`.

## Usage

This mod works on the server and client, but you only need to install it on the side that generates the world.\
So if you're running a dedicated server, just install it on that.

Once installed, start the server and a configuration will be generated at `config/biomesizenf-common.toml`:
```toml
# The modifier to apply to the biome size (- is smaller, + is larger).
# Default: 0
# Range: -8 ~ 8
biomeSizeModifier = 0
```
You can then change the value to your liking, stop the server, **delete the world**, and start it again.\
If you want something that looks similar to the `Large Biomes` world type, use a value of `2`.

## Credits

A big thank you goes out to [someaddons] for the Biome Sizes mod, which this mod is based on.\
You can find the original mod [here][mod] on CurseForge, and the source code [here][source] on GitHub.

[someaddons]: https://github.com/someaddons
[mod]: https://www.curseforge.com/minecraft/mc-mods/biomesize
[source]: https://github.com/someaddons/biomesizes/tree/fabric1.21
