package com.example.core
import com.example.core.db.DataBaseImpl
import com.example.core.db.Database
import org.koin.dsl.module

val coreModules = module {
    single<Database> { DataBaseImpl("codex") }

}