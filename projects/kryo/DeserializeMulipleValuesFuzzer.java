// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.KryoException;
import java.io.*;
import java.util.*;

public class DeserializeMulipleValuesFuzzer {
	public static void fuzzerTestOneInput(byte[] input) {
		Kryo kryo = new Kryo();
		kryo.register(SomeClass.class);

		try {
			Input in = new Input(input);
			SomeClass object = kryo.readObject(in, SomeClass.class);
			in.close();
		} catch (KryoException e) {
		}
		
	}
	static public class SomeClass {
		private List<String> _emptyList = Collections.emptyList();
		private Set<String> _emptySet = Collections.emptySet();
		private Map<String, String> _emptyMap = Collections.emptyMap();
		private List<String> _singletonList = Collections.singletonList("foo");
		private Set<String> _singletonSet = Collections.emptySet();
		private Map<String, String> _singletonMap;
		private TreeSet<String> _treeSet;
		private TreeMap<String, Integer> _treeMap;
		private List<String> _arrayList;
		private Set<String> _hashSet;
		private Map<String, Integer> _hashMap;
		private List<Integer> _asList = Arrays.asList(1, 2, 3);
		private int[] _intArray;
		private long[] _longArray;
		private short[] _shortArray;
		private float[] _floatArray;
		private double[] _doubleArray;
		private byte[] _byteArray;
		private char[] _charArray;
		private String[] _stringArray;
		private BitSet _bitSet;
	}

}
