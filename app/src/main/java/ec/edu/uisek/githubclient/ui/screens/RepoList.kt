package ec.edu.uisek.githubclient.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ec.edu.uisek.githubclient.ui.components.RepoItem

@Composable
fun RepoList() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all=16.dp)
    )   {

        RepoItem(
            name = "Proyecto de Django",
            description = "Un nuevo proyecto realizado en Django",
            avatarIng = "https://avatars.githubusercontent.com/u/1?v=4",
            language = "Python"

        )
        RepoItem(
            name = "Proyecto de Django",
            description = "Un nuevo proyecto realizado en Django",
            avatarIng = "https://avatars.githubusercontent.com/u/1?v=4",
            language = "TypeScript"
        )
        RepoItem(
            name = "Proyecto de Django",
            description = "Un nuevo proyecto realizado en Django",
            avatarIng = "https://avatars.githubusercontent.com/u/1?v=4",
            language = "Kotlin"
        )
        RepoItem(
            name = "Proyecto de Django",
            description = "Un nuevo proyecto realizado en Django",
            avatarIng = "https://avatars.githubusercontent.com/u/1?v=4",
            language = "IDK"
        )
    }
}