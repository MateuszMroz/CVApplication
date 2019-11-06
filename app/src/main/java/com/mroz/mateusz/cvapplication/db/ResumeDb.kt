package com.mroz.mateusz.cvapplication.db


abstract class CvDb {
    abstract fun resumeDao() : ResumeDao
}