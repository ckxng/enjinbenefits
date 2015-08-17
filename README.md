# Enjin Benefits

[Enjin](http://www.enjin.com), a Minecraft community hosting provider, 
provides a number of useful features for server operators.  One of these 
features is to track points and manage donations for a server.  Unfortunately, 
Enjin does not yet support 1.7.10, but they do provide an API.  This is a very 
simple mod that will allow me to use Enjin points on my 1.7.10 Forge server.

# Status

This software is ABANDONED.

Interest in this mod tapered off, but the code still serves as a working 
example of how to leverage the Engin API from inside a Minecraft mod.

At the time the mod was abandoned it had two features:
- Dynamically generated config file
- A call to the Enjin API to determine what "Points" are called on this server

# For Developers

- Clone this repository into enjinbenefits/
- Run `gradlew setupDevWorkspace`

If you are using Eclipse, do this next:
- Run `gradlew eclipse`
- Open the workspace enjinbenefits/eclipse/

# Copying

enjinbenefits is licensed under the 2-CLAUSE BSD LICENSE.  See LICENSE.txt
for details.
