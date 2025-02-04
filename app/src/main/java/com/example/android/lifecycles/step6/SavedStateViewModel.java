/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.step6;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class SavedStateViewModel extends ViewModel {

    // STEP 6: Create constructor and use the LiveData from SavedStateHandle.
    private SavedStateHandle mState;

    public SavedStateViewModel(SavedStateHandle savedStateHandle) {
        mState = savedStateHandle;
    }

//    private MutableLiveData<String> name = new MutableLiveData<>();

    // Expose an immutable LiveData
//    LiveData<String> getName() {
//        return name;
//    }
//
//    void saveNewName(String newName) {
//        name.setValue(newName);
//    }

    // STEP 6: Now you'll use the module's LiveData support so you don't need to store and expose a
    // LiveData in your ViewModel anymore. Replace the existing getter and saveNewName above:
    private static final String NAME_KEY = "name";

    // Expose an immutable LiveData
    LiveData<String> getName() {
        return mState.getLiveData(NAME_KEY);
    }

    void saveNewName(String newName) {
        mState.set(NAME_KEY, newName);
    }

}
