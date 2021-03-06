// Generated by shift-spec-java/reducer.js

/**
 * Copyright 2016 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shapesecurity.shift.es2017.parser;

import com.shapesecurity.functional.data.Maybe;
import com.shapesecurity.functional.data.Monoid;
import com.shapesecurity.shift.es2017.ast.BindingIdentifier;
import com.shapesecurity.shift.es2017.ast.Node;
import com.shapesecurity.shift.es2017.reducer.WrappedReducer;
import com.shapesecurity.shift.es2017.reducer.MonoidalReducer;
import javax.annotation.Nonnull;

import static org.junit.Assert.assertTrue;

public class RangeCheckerReducer extends WrappedReducer<RangeCheckerReducer.RangeChecker> {
    protected RangeCheckerReducer(ParserWithLocation parserWithLocation) {
        super((node, range) -> accept(parserWithLocation, node, range), new MonoidalReducer<>(RangeChecker.MONOID));
    }

    private static RangeChecker accept(ParserWithLocation parserWithLocation, Node node, RangeChecker innerBounds) {
        Maybe<SourceSpan> span = parserWithLocation.getLocation(node);

        if (node instanceof BindingIdentifier && ((BindingIdentifier) node).name.equals("*default*")) {
            assertTrue(span.isNothing());
            return innerBounds;
        }

        assertTrue(span.isJust());
        RangeChecker outerBounds = new RangeChecker(span.fromJust());
        assertTrue(outerBounds.start <= outerBounds.end);

        assertTrue(outerBounds.start <= innerBounds.start);
        assertTrue(innerBounds.end <= outerBounds.end);

        return outerBounds;
    }

    static class RangeChecker {
        public final static Monoid<RangeChecker> MONOID = new Monoid<RangeChecker>() {
            @Nonnull
            @Override
            public RangeChecker identity() {
                return new RangeChecker(Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            @Nonnull
            @Override
            public RangeChecker append(RangeChecker a, RangeChecker b) {
                assertTrue(a.end <= b.start);
                return new RangeChecker(a.start, b.end);
            }
        };
        public final int start, end;

        private RangeChecker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public RangeChecker(SourceSpan sourceSpan) {
            this(sourceSpan.start.offset, sourceSpan.end.offset);
        }
    }
}
