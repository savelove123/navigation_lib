/*
 * Copyright 2023 , Felix Huang and the AwesomeNavigation project contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("UNCHECKED_CAST")

package com.felix.android.navigation

import android.os.Parcelable

/**
 * 表示是一个参数化的对象，
 * 需要依赖外部输入参数
 */
interface Parameterized<T:Parcelable>{

    fun Parcelable.reifiedParams():T{
        return this as T
    }

    fun Parcelable?.reifiedOrNull():T?{
        return this as? T
    }

}

