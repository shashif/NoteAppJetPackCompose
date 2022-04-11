package com.example.noteappjetpackcompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteappjetpackcompose.screen.NoteScreen
import com.example.noteappjetpackcompose.screen.NoteViewModel
import com.example.noteappjetpackcompose.ui.theme.NoteAppJetPackComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel)


                    //Start
//                    val notes = remember {
//                        mutableStateListOf<Note>()
//                    }
//
//                    NoteScreen(
//                        notes = notes,
//                        onAddNote = {
//                            notes.add(it)
//                        },
//                        onRemoveNote = {
//                            notes.remove(it)
//                        }
//                    )
                    //End


                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {
    val notesList = noteViewModel.getAllNotes()
    NoteScreen(
        notes = notesList,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppJetPackComposeTheme {

    }
}