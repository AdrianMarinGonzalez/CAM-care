package com.amaringo.presentation.feature.center_list.model


sealed class CenterCategory { abstract val id: String; abstract val title: String; abstract val icon: String }

data class Senior(override val id: String, override val title: String, override val icon: String) : CenterCategory()
data class Culture(override val id: String, override val title: String, override val icon: String) : CenterCategory()
data class ChildrenShelter(override val id: String, override val title: String, override val icon: String) : CenterCategory()
data class SocialServices(override val id: String, override val title: String, override val icon: String) : CenterCategory()
data class DayCare(override val id: String, override val title: String, override val icon: String) : CenterCategory()