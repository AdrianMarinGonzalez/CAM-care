package com.amaringo.presentation.feature.center_list.model


sealed class Center { abstract val id: String; abstract val title: String; abstract val location: Location }

data class Senior(override val id: String, override val title: String, override val location: Location) : Center()
data class Culture(override val id: String, override val title: String, override val location: Location) : Center()
data class ChildrenShelter(override val id: String, override val title: String, override val location: Location) : Center()
data class SocialServices(override val id: String, override val title: String, override val location: Location) : Center()
data class DayCare(override val id: String, override val title: String, override val location: Location) : Center()
