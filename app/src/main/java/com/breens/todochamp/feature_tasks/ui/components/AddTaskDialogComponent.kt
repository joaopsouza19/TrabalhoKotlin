package com.breens.todochamp.feature_tasks.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.breens.todochamp.feature_tasks.state.TasksScreenUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskDialogComponent(
    setTaskTitle: (String) -> Unit,
    setTaskBody: (String) -> Unit,
    saveTask: () -> Unit,
    closeDialog: () -> Unit,
    uiState: TasksScreenUiState,
) {
    Dialog(onDismissRequest = { closeDialog() }) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
        ) {
            LazyColumn(contentPadding = PaddingValues(12.dp)) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Nova Tarefa",
                            fontSize = 18.sp
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = uiState.currentTextFieldTitle,
                        onValueChange = { title ->
                            setTaskTitle(title)
                        },
                        label = { Text("Título") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Blue,
                            unfocusedBorderColor = Color.Blue,
                            focusedLabelColor = Color.Blue,
                            unfocusedLabelColor = Color.Blue,
                            cursorColor = Color.Blue,
                        ),
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = uiState.currentTextFieldBody,
                        onValueChange = { body ->
                            setTaskBody(body)
                        },
                        label = { Text("Descrição") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Blue,
                            unfocusedBorderColor = Color.Blue,
                            focusedLabelColor = Color.Blue,
                            unfocusedLabelColor = Color.Blue,
                            cursorColor = Color.Blue,
                        ),
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Button(
                            onClick = {
                                saveTask()
                                setTaskTitle("")
                                setTaskBody("")
                                closeDialog()
                            },
                            modifier = Modifier.padding(horizontal = 12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue,
                                contentColor = Color.White,
                            ),
                        ) {
                            Text(text = "Salvar")
                        }
                    }
                }
            }
        }
    }
}
